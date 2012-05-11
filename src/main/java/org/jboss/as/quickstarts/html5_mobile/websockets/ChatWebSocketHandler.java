/*
 * JBoss, Home of Professional Open Source
 * Copyright 2012, Red Hat, Inc. and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.jboss.as.quickstarts.html5_mobile.websockets;


import org.jboss.as.quickstarts.html5_mobile.model.Member;
import org.jboss.as.websockets.WebSocket;
import org.jboss.as.websockets.servlet.WebSocketServlet;
import org.jboss.websockets.Frame;
import org.jboss.websockets.frame.TextFrame;

import javax.enterprise.event.Observes;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author <a href="mailto:whales@redhat.com">Wesley Hales</a>
 */

@WebServlet("/websocket/")
public class ChatWebSocketHandler extends WebSocketServlet {
    private static Set<WebSocket> websockets = new HashSet<WebSocket>();

    public void observeItemEvent(@Observes Member member) {
        try {
            for (WebSocket socket : getWebsockets()) {
                socket.writeFrame(TextFrame.from("{\"cdievent\":{\"fire\":function(){" +
                        "eventObj.initEvent(\'memberEvent\', true, true);" +
                        "eventObj.name = '" +  member.getName() + "';\n" +
                        "document.dispatchEvent(eventObj);" +
                        "}}}"));
            }
        } catch (IOException x) {
            //todo - do something
        }
    }

    @Override
    protected void onSocketOpened(WebSocket socket) throws IOException {
        System.out.println("Websocket opened :)");
        websockets.add(socket);
    }

    @Override
    protected void onSocketClosed(WebSocket socket) throws IOException {
        System.out.println("Websocket closed :(");
        websockets.remove(socket);
    }

    @Override
    protected void onReceivedFrame(WebSocket socket) throws IOException {
        final Frame frame = socket.readFrame();
        if (frame instanceof TextFrame) {
            final String text = ((TextFrame) frame).getText();
            if ("Hello".equals(text)) {
                socket.writeFrame(TextFrame.from("Hey, there!"));
            }
            try {
                for (WebSocket asocket : getWebsockets()) {
                    System.out.println("!!!!!!!!!!!!!!!!!!" + asocket.getSocketID());
                    // send a message to the current client WebSocket.
                    asocket.writeFrame(TextFrame.from(text));
                }
            } catch (IOException x) {
                // Error was detected, close the ChatWebSocket client side
                System.out.println("!!!!!!!!!!!!!!!!!!huge problem");
            }
        }
    }

    public static synchronized Set<WebSocket> getWebsockets() {
        return websockets;
    }

}
