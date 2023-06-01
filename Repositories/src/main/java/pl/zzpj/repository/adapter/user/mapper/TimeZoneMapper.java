package pl.zzpj.repository.adapter.user.mapper;

import org.springframework.stereotype.Component;
import pl.zzpj.repository.core.domain.model.userModel.UserTimeZone;
import pl.zzpj.repository.data.user.TimeZone;

@Component
public class TimeZoneMapper {

  public TimeZone mapToDatabaseTimeZone(UserTimeZone userTimeZone) {
    if (userTimeZone == null) {
      return null;
    }

    return switch (userTimeZone) {
      case AMERICA_CHICAGO -> TimeZone.AMERICA_CHICAGO;
      case AMERICA_LOS_ANGELES -> TimeZone.AMERICA_LOS_ANGELES;
      case AMERICA_NEW_YORK -> TimeZone.AMERICA_NEW_YORK;
      case AMERICA_SAO_PAULO -> TimeZone.AMERICA_SAO_PAULO;
      case ASIA_SHANGHAI -> TimeZone.ASIA_SHANGHAI;
      case ASIA_TOKYO -> TimeZone.ASIA_TOKYO;
      case AUSTRALIA_SYDNEY -> TimeZone.AUSTRALIA_SYDNEY;
      case EUROPE_BERLIN -> TimeZone.EUROPE_BERLIN;
      case EUROPE_LONDON -> TimeZone.EUROPE_LONDON;
      case EUROPE_WARSAW -> TimeZone.EUROPE_WARSAW;
    };
  }

  public UserTimeZone mapToDomainModelTimeZone(TimeZone timeZone) {
    if (timeZone == null) {
      return null;
    }

    return switch (timeZone) {
      case AMERICA_CHICAGO -> UserTimeZone.AMERICA_CHICAGO;
      case AMERICA_LOS_ANGELES -> UserTimeZone.AMERICA_LOS_ANGELES;
      case AMERICA_NEW_YORK -> UserTimeZone.AMERICA_NEW_YORK;
      case AMERICA_SAO_PAULO -> UserTimeZone.AMERICA_SAO_PAULO;
      case ASIA_SHANGHAI -> UserTimeZone.ASIA_SHANGHAI;
      case ASIA_TOKYO -> UserTimeZone.ASIA_TOKYO;
      case AUSTRALIA_SYDNEY -> UserTimeZone.AUSTRALIA_SYDNEY;
      case EUROPE_BERLIN -> UserTimeZone.EUROPE_BERLIN;
      case EUROPE_LONDON -> UserTimeZone.EUROPE_LONDON;
      case EUROPE_WARSAW -> UserTimeZone.EUROPE_WARSAW;
    };
  }
}
