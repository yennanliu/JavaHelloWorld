package Advances.IOFlow;

// https://www.youtube.com/watch?v=kqG8IQNMN_s&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=584
// https://www.youtube.com/watch?v=lms-HDCYCvQ&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=586

/**
 *  IOFlow demo 1
 *
 *   1) I/O : input/output. for data transferred (across devices)
 *   2) Java does data transfer via  "stream"
 *   3) java.io package offers various "stream" class, and interfaces
 *      -> for different data type
 *      -> use STDIN, STDOUT in general
 *
 *
 *   Types of I/O flow
 *
 *   1) based on unit: 字節流 (8 bit), 字符流 (16 bit)
 *      ->  字節流 (8 bit) :  byte           : for picture, video files (non-text files)
 *      ->  字符流 (16 bit) : char  (2 byte) : for text files
 *
 *   2) based in flow : inputStream, outputStream
 *   3) based on roles : 節點流, 處理流
 *
 *   4) I/O flow structure - 1
 *    abstract class  | 字節流         |  字符流
 *        輸入流       | inputStream   |  Reader
 *        輸出流       | outputStream  |  Writer
 *
 *
 *
 *   5) I/O flow structure - 2
 *
 *    abstract class  |  節點流             |  緩衝流
 *     InputStream    |  FileInputStream   |  BufferedInputStream
 *     OutputStream   |  FileOutputStream  |  BufferedOutputStream
 *     Reader         |  FileReader        |  BufferedReader
 *     Writer         |  FileWriter        |  BufferedFileWriter
 */

public class demo1 {
}
