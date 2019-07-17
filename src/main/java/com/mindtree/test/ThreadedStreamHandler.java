package com.mindtree.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;


class ThreadedStreamHandler extends Thread {


	InputStream inputStream;
	String adminPassword;
	OutputStream outputStream;
	PrintWriter printWriter;
	StringBuilder outputBuffer = new StringBuilder();
	private boolean sudoIsRequested = false;





	/**
	 * A simple constructor for when the sudo command is not necessary.
	 * This constructor will just run the command you provide, without
	 * running sudo before the command, and without expecting a password.
	 *
	 * @param inputStream
	 * @param streamType
	 */
	ThreadedStreamHandler(InputStream inputStream) {
		this.inputStream = inputStream;
	}





	/**
	 * Use this constructor when you want to invoke the 'sudo' command.
	 * The outputStream must not be null. If it is, you'll regret it. :)
	 *
	 * this currently hangs if the admin password given for the sudo command is wrong.
	 *
	 * @param inputStream
	 * @param streamType
	 * @param outputStream
	 * @param adminPassword
	 */
	ThreadedStreamHandler(InputStream inputStream, OutputStream outputStream, String adminPassword) {
		this.inputStream = inputStream;
		this.outputStream = outputStream;
		this.printWriter = new PrintWriter(outputStream);
		this.adminPassword = adminPassword;
		this.sudoIsRequested = true;
	}





	@Override
	public void run() {
		// on mac os x 10.5.x, when i run a 'sudo' command, i need to write
		// the admin password out immediately; that's why this code is
		// here.
		if (sudoIsRequested) {
			printWriter.println(adminPassword);
			printWriter.flush();
		}

		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				outputBuffer.append(line + "\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (bufferedReader != null) {
					bufferedReader.close();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}





	public StringBuilder getOutputBuffer() {
		return outputBuffer;
	}

}

