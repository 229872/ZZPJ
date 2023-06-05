package pl.zzpj.repository.core.domain.model.userModel;

public enum UserTimeZone {
  EUROPE_WARSAW("Europe/Warsaw"),
  AMERICA_NEW_YORK("America/New_York"),
  AMERICA_LOS_ANGELES("America/Los_Angeles"),
  ASIA_TOKYO("Asia/Tokyo"),
  AUSTRALIA_SYDNEY("Australia/Sydney"),
  EUROPE_LONDON("Europe/London"),
  EUROPE_BERLIN("Europe/Berlin"),
  AMERICA_CHICAGO("America/Chicago"),
  ASIA_SHANGHAI("Asia/Shanghai"),
  AMERICA_SAO_PAULO("America/Sao_Paulo");

  private final String name;

  UserTimeZone(String name) {
    this.name = name;
  }

  public String getDisplayName() {
    return name;
  }
}
