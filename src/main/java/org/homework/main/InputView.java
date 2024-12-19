package org.homework.main;

import org.homework.domain.Todo;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.HashMap;

public class InputView {
  private BufferedReader br;

  public InputView(InputStream in) {
    this.br = new BufferedReader(new InputStreamReader(in));
  }

  public String input() throws IOException {
      return br.readLine();
  }
}
