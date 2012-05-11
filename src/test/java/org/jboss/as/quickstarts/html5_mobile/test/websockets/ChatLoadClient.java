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
package org.jboss.as.quickstarts.html5_mobile.test.websockets;



import java.io.IOException;
import java.net.URI;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author <a href="mailto:whales@redhat.com">Wesley Hales</a>
 */
public class ChatLoadClient
{


    public static void main(String... arg) throws Exception
    {


//      WebSocketClientFactory factory = new WebSocketClientFactory();
//        factory.setBufferSize(4096);
//        factory.start();
//
//      WebSocketClient client = factory.newWebSocketClient();
//      //client.setBufferSize(4096);
//      client.setMaxIdleTime(300000);
//      client.setProtocol("chat");
//      //client.start();
//
//        final long startTime = System.currentTimeMillis();
//        final long endTime;
//        try {
//
//
//      for (int i =0;i<6000;i++){
//      final int marker = i;
//      WebSocket.Connection connection = client.open(new URI("ws://192.168.1.101:8081/"), new WebSocket.OnTextMessage()
//       {
//         public void onOpen(Connection connection)
//         {
//           // open notification
//             //System.out.println("-----------------------1");
//         }
//
//         public void onClose(int closeCode, String message)
//         {
//           // close notification
//            System.out.println("-----------------------CLOSE: " + marker + " : " + message);
//         }
//
//         public void onMessage(String data)
//         {
//             //System.out.println("-----------------------3:" + marker + " : " + data);
//           // handle incoming message
//         }
//       }).get(5, TimeUnit.SECONDS);
//
//       connection.sendMessage("Hello World " + marker);
//      }
//
//
//        } finally {
//          endTime = System.currentTimeMillis();
//        }
//        final long duration = endTime - startTime;
//        System.out.println("-----------------------That took: " + duration + "ms");
//
//    }


}
}