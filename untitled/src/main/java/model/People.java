package model;

public class People {

  private String name;
  private String surname;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getBirthData() {
    return birthData;
  }

  public void setBirthData(String birthData) {
    this.birthData = birthData;
  }

  public void setNameSurname(String nameSurname) {
    this.nameSurname = nameSurname;
  }

  private String birthData;
  private String nameSurname;

  public String getNameSurname() {
    return nameSurname;
  }

  public void setNameSurname() {
    this.nameSurname = this.name + " " + this.surname;
  }

  @Override
  public String toString() {
    return name + " " + surname + " " + birthData + " " + nameSurname;
  }
}
