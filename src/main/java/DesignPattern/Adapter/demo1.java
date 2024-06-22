package DesignPattern.Adapter;

// https://www.runoob.com/design-pattern/adapter-pattern.html

/**
 * 適配器模式（Adapter Pattern）是作為兩個不相容的介面之間的橋樑。 這種類型的設計模式屬於結構型模式，它結合了兩個獨立介面的功能。
 * 這種模式涉及到一個單一的類，該類別負責加入獨立的或不相容的介面功能。 舉個真實的例子，讀卡機是作為記憶卡和筆記本之間的轉接器。
 * 您將記憶體卡插入讀卡器，再將讀卡機插入筆記本，這樣就可以透過筆記本來讀取記憶卡。 我們透過下面的實例來示範適配器模式的使用。 其中，音訊播放器設備只能播放 mp3
 * 文件，透過使用一個更高級的音訊播放器來播放 vlc 和 mp4 文件。
 *
 * <p>意圖：將一個類別的介面轉換成客戶希望的另外一個介面。 適配器模式使得原本由於介面不相容而無法一起工作的那些類別可以一起工作。
 *
 * <p>主要解決：主要解決在軟體系統中，常常要將一些"現存的物件"放到新的環境中，而新環境要求的介面是現對像不能滿足的。
 *
 * <p>何時使用： 1、系統需要使用現有的類，而此類的介面不符合系統的需要。
 * 2.想要建立一個可以重複使用的類，用於與一些彼此之間沒有太大關聯的一些類，包括一些可能在將來引進的類一起工作，這些源類不一定有一致的接口。 3.透過介面轉換，將一個類別插入另一個類別系中。
 * （例如老虎和飛禽，現在多了一個飛虎，在不增加實體的需求下，增加一個適配器，在裡麵包容一個虎對象，實現飛的接口。）
 *
 * <p>如何解決：繼承或依賴（建議）。
 *
 * <p>關鍵代碼：適配器繼承或依賴現有的對象，實現想要的目標介面。
 */
interface MediaPlayer {
  void play(String audioType, String fileName);
}

interface AdvancedMediaPlayer {
  void playVlc(String fileName);

  void playMp4(String fileName);
}

class VlcPlayer implements AdvancedMediaPlayer {

  @Override
  public void playVlc(String fileName) {
    System.out.println("Playing vlc file. Name: " + fileName);
  }

  @Override
  public void playMp4(String fileName) {
    // do nothing
  }
}

class Mp4Player implements AdvancedMediaPlayer {

  @Override
  public void playVlc(String fileName) {
    // do nothing
  }

  @Override
  public void playMp4(String fileName) {
    System.out.println("Playing mp4 file. Name: " + fileName);
  }
}

// create MediaAdapter via implment MediaPlayer
class MediaAdapter implements MediaPlayer {

  AdvancedMediaPlayer advancedMediaPlayer;

  // constructor
  MediaAdapter(String audioType) {
    if (audioType.equalsIgnoreCase("vlc")) {
      advancedMediaPlayer = new VlcPlayer();

    } else if (audioType.equalsIgnoreCase("mp4")) {
      advancedMediaPlayer = new Mp4Player();
    }
  }

  @Override
  public void play(String audioType, String fileName) {
    if (audioType.equalsIgnoreCase("vlc")) {
      advancedMediaPlayer.playVlc(fileName);
    } else if (audioType.equalsIgnoreCase("mp4")) {
      advancedMediaPlayer.playMp4(fileName);
    }
  }
}

class AudioPlayer implements MediaPlayer {

  MediaAdapter mediaAdapter;

  @Override
  public void play(String audioType, String fileName) {

    // play mp3
    if (audioType.equalsIgnoreCase("mp3")) {
      System.out.println("Playing mp3 file. Name: " + fileName);
    }
    // vlc or mp4
    else if (audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")) {
      mediaAdapter = new MediaAdapter(audioType);
      mediaAdapter.play(audioType, fileName);
    } else {
      System.out.println("Invalid media. " + audioType + " format not supported");
    }
  }
}

public class demo1 {
  public static void main(String[] args) {

    // run
    AudioPlayer audioPlayer = new AudioPlayer();

    audioPlayer.play("mp3", "beyond the horizon.mp3");
    audioPlayer.play("mp4", "alone.mp4");
    audioPlayer.play("vlc", "far far away.vlc");
    audioPlayer.play("avi", "mind me.avi");
  }
}
