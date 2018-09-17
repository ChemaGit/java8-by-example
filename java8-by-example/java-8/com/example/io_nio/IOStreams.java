package com.example.io_nio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class IOStreams {

	public static void main(String[] args) {
		/**Example use of InputStream methods**/
		//exampleInputStream(args);
		/**CHARACTER STREAM READER METHODS**/
		//exampleReaderStream(args);
		/**CHAINED STREAMS: EXAMPLE**/
		//chainedStreamsExample(args);
		/**CONSOLE I/O**/
		/**READING FOR THE STANDARD INPUT**/
		//readingForStandardInput(args);
		/**CHANNEL I/O **/
		//channelIO(args);
		/**PERSISTENCE AND SERIALIZATION**/
		//serializationExample(args);
		/**WRITING A SIMPLE INTERACTIVE CONSOLE I/O APPLICATION**/
		if(args.length < 1) {
			System.out.println("Usage: java FileScanInteractive <File to search> ");
			System.exit(-1);
		}
		
		String file = args[0];
		FileScanInteractive fsi = new FileScanInteractive();
		try(BufferedReader in = new BufferedReader(new InputStreamReader(System.in))){
			String search = "";
			System.out.println("Searching through the file: " + file);
			System.out.println();
			while(true) {
				System.out.print("Introduce a word to search: ");
				search = in.readLine().trim();
				if(search.equalsIgnoreCase("q")) {
					System.out.println();
					System.out.println("Quitting of the application.");
					break;
				}
				int count = fsi.countTokens(file, search);
				System.out.println();
				System.out.println("The word \"" + search + "\" appears " + count + " times in the file.");
				System.out.println();
			}
		}catch(IOException e) {//Catch any Exceptions.
			System.out.println("Exception: " + e);
			System.exit(-1);
		}
		
		/**SERIALIZING AND DESERIALIZING A SHOPPING CART**/
	}
	
	/**Example InputStream methods**/
	private static void exampleInputStream(String[] args) {
		// Byte Stream. Example
		byte[] b = new byte[128];		
		//Try block with classes autocloseable
		//InputStream implements AutoCloseable, which means that if you use an InputStreas in a try-with-resources
		//block, the stream is automatically closed at the end of the try
		try (FileInputStream fis = new FileInputStream(args[0]);
			 FileOutputStream fos = new FileOutputStream(args[1])) {
			System.out.println("Bytes available: " + fis.available());
			int count = 0;
			int read = 0;
			while((read = fis.read(b)) != -1) {
				fos.write(b);
				count += read;
				b = new byte[128];
			}
			System.out.println("Wrote: " + count);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File not found: " + e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("IOException: " + e);
		}		
	}
	
	/**CHARACTER STREAM READER METHODS**/
	private static void exampleReaderStream(String[] args) {
		char[] c = new char[128];
		//Example use of ReaderStream methods
		//Try block with classes autocloseable
		//InputStream implements AutoCloseable, which means that if you use an InputStreas in a try-with-resources
		//block, the stream is automatically closed at the end of the try		
		try (FileReader fr = new FileReader(args[0]);
			 FileWriter fw = new FileWriter(args[1])) {
			int count = 0;
			int read = 0;
			while ((read = fr.read(c)) != -1) {
				fw.write(c);
				count += read;
				c = new char[128];			
			}
		} catch (FileNotFoundException e) {
			System.out.println("File " + args[0] + " not found.");
		} catch (IOException e) {
			System.out.println("IOException: " + e);
		}
	}
	
	/**CHAINED STREAMS: EXAMPLE**/
	private static void chainedStreamsExample(String[] args) {
		//Try block with classes autocloseable
		//InputStream implements AutoCloseable, which means that if you use an InputStreas in a try-with-resources
		//block, the stream is automatically closed at the end of the try		
		try(BufferedReader bufInput = new BufferedReader(new FileReader(args[0]));
			BufferedWriter bufOutput = new BufferedWriter(new FileWriter(args[1]))) {
			String line = "";
			while((line = bufInput.readLine()) != null) {
				bufOutput.write(line);
				bufOutput.newLine();
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + e);
		} catch (IOException e) {
			System.out.println("Exception: " + e);
		}
	}
	
	/**READING FOR THE STANDARD INPUT**/
	private static void readingForStandardInput(String[]args) {
		String s = "";
		//Try block with classes autocloseable
		//InputStream implements AutoCloseable, which means that if you use an InputStreas in a try-with-resources
		//block, the stream is automatically closed at the end of the try			
		try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
			System.out.print("Type xyz to exit: ");
			s = in.readLine();
			while(s != null) {
				System.out.println("Read: " + s.trim());
				if(s.equals("xyz")) {
					System.exit(0);
				}
				System.out.println("Type xyz to exit: ");
				s = in.readLine();
			}
		} catch (IOException e) {			
			System.out.println("Exception: " + e);
		}
	}

	/**CHANNEL I/O**/
	private static void channelIO(String[] args) {
		//Try block with classes autocloseable
		//InputStream implements AutoCloseable, which means that if you use an InputStreas in a try-with-resources
		//block, the stream is automatically closed at the end of the try				
		try(FileChannel fcIn = new FileInputStream(args[0]).getChannel();
			FileChannel fcOut = new FileOutputStream(args[1]).getChannel()) {
			ByteBuffer buff = ByteBuffer.allocate((int)fcIn.size());
			fcIn.read(buff);
			buff.position(0);
			fcOut.write(buff);
		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + e);
		} catch (IOException e) {
			System.out.println("IOException: " + e);
		}
	}
	
	/**PERSISTENCE AND SERIALIZATION**/
	private static void serializationExample(String []args) {
		Stock s1 = new Stock("ORCL", 100, 32.50);
		Stock s2 = new Stock("APPL", 100, 245);
		Stock s3 = new Stock("GOOG", 100, 54.67);
		
		Portfolio por = new Portfolio();
		por.addStock(s1);		
		por.addStock(s2);
		por.addStock(s3);
		
		try(FileOutputStream fos = new FileOutputStream(args[0]); ObjectOutputStream out = new ObjectOutputStream(fos)) {
			out.writeObject(por);
		} catch (IOException e) {
			System.out.println("Exception writing out portfolio: " + e);
		}
		
		try (FileInputStream fis = new FileInputStream(args[0]);ObjectInputStream in = new ObjectInputStream(fis)) {
			Portfolio newP = (Portfolio)in.readObject();
		} catch (ClassNotFoundException | IOException e) {
			System.out.println("Exception reading in portfolio: " + e);
		}
	}
}
