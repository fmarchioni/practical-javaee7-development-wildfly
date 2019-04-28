package com.itbuzzpress.chapter9.endpoint;

import java.awt.image.BufferedImage;
import java.io.*;
 
import java.nio.ByteBuffer;

import javax.imageio.ImageIO;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/hellobinary")
public class HelloWorldBinaryEndpoint {

	@OnOpen
	public void hello(Session session) {

	}

	@OnMessage
	public ByteBuffer message(String fileName) {

		File fi = new File(fileName);

		ByteBuffer buf = null;
		try {

			BufferedImage image = ImageIO.read(fi);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();

	               
			ImageIO.write(image, "png", baos);
			byte[] byteArray = baos.toByteArray();
			buf = ByteBuffer.wrap(byteArray);
			System.out.println("Sent binary " + byteArray.length);
        

		} catch (IOException e) {
			e.printStackTrace();
		}
		return buf;
	}

	@OnError
	public void error(Throwable t) {
		System.out.println("Oops! " + t.getMessage());
	}

}
