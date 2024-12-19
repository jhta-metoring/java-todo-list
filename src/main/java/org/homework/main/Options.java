package org.homework.main;

public enum Options {
  //저장, 검색, 수정, 삭제
  //OPTIONS = {"1.추가", "2.검색", "3.수정", "4.전체 조회", "5.삭제", "6.완료", "7.종료"};
  ADD("1"), SEARCH("2"), EDIT("3"), ALL("4"), DELETE("5"), DONE("6"), EXIT("7");

  final private String name;

  private Options(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public static Options nameOf(String name) {
    for (Options o : Options.values()) {
      if(o.getName().equals(name)) {
        return o;
      }
    }
    return null;
  }

}
