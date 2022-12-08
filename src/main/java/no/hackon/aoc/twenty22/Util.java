package no.hackon.aoc.twenty22;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;

public class Util {
  private Util(){}
  public static String getDayInput(String fileName) {
    try {
      return Files.readString(new File(Util.class.getClassLoader().getResource(fileName).toURI()).toPath());
    } catch (IOException | URISyntaxException e) {
    } // TODO Auto-generated catch block

    return "";
  }

}
