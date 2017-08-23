package com.ataybur.javaNioExample;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Scanner;

public class CrunchifyNIOClient2 {
	public static void main(String[] args) throws IOException, InterruptedException {

		InetSocketAddress crunchifyAddr = new InetSocketAddress("localhost", 1111);
		SocketChannel crunchifyClient = SocketChannel.open(crunchifyAddr);

		Scanner reader = new Scanner(System.in); // Reading from System.in
		while (true) {
			System.out.println("Enter a number: ");
			String input = reader.next(); // Scans the next token of the input
											// as an
											// int.

			byte[] message = new String(input).getBytes();
			ByteBuffer buffer = ByteBuffer.wrap(message);
			crunchifyClient.write(buffer);

			buffer.clear();
			if(input.equals("q")){
				break;
			}
		}
		// wait for 2 seconds before sending next message
		// Thread.sleep(2000);

		crunchifyClient.close();
	}
}
