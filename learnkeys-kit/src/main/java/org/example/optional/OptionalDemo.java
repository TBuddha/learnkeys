package org.example.optional;

/**
 * @author zhout
 * @date 2020/11/16 11:13
 */
public class OptionalDemo {

  //  例1
  //  private void getIsoCode(User user) {
  //    if (user != null) {
  //      Address address = user.getAddress();
  //      if (address != null) {
  //        Country country = address.getCountry();
  //        if (country != null) {
  //          String isocode = country.getIsocode();
  //          if (isocode != null) {
  //            isocode = isocode.toUpperCase();
  //          }
  //        }
  //      }
  //    }
  //  }

  // ==>

  // String isoCode = Optional.ofNullable(user)
  //  .map(User::getAddress)  //Optional<Address>
  //  .map(Address::getCountry)  //Optional<Country>
  //  .map(Country::getIsocode)  // Optional<String>
  //  .orElse("empty");

  // =========================================================//

  // 例2
  // 获取用户的地区 code
  //  public String getUserCountryCode(UserInfo user) {
  //    String countryCode = "";
  //    if (user != null) {
  //      Address address = user.getAddress();
  //      if (address != null) {
  //        Country country = address.getCountry();
  //        if (country != null) {
  //          String code = country.getCountryCode();
  //          if (code != null) {
  //            countryCode = code.toUpperCase();
  //          }
  //        }
  //      }
  //    }
  //    return countryCode;
  //  }

  // ==>
  //  public String getUserCountryCodByOptional(UserInfor user) {
  //    return Optional.ofNullable(user)
  //        .map(c -> c.getAddress())
  //        .map(r -> r.getCountry())
  //        .map(u -> u.getCountryCode())
  //        .orElseThrow(() -> new IllegalArgumentException(" 无法获取到新的值")).toUpperCase();
  //  }
  // OR
  //  public String getUserCountryCodByOptional2(UserInfo user) {
  //    return Optional.ofNullable(user)
  //        .map(UserInfo::getAddress)
  //        .map(Address::getCountry)
  //        .map(Country::getCountryCode)
  //        .orElseThrow(() -> new IllegalArgumentException("无法获取到新的值"))
  //        .toUpperCase();
  //  }
}
