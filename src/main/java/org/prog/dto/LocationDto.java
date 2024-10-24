package org.prog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LocationDto {
    private StreetDto street;
    private String city;
    private String state;
    private String country;
    private String postcode;
    private CoordinatesDto coordinates;
    private TimezoneDto timezone;

}

//      "location": {
//              "street": {
//              "number": 8148,
//              "name": "Pine Rd"
//              },
//              "city": "Selkirk",
//              "state": "Nova Scotia",
//              "country": "Canada",
//              "postcode": "Q3V 6A5",
//              "coordinates": {
//              "latitude": "-70.3580",
//              "longitude": "-88.0920"
//              },
//              "timezone": {
//              "offset": "-3:00",
//              "description": "Brazil, Buenos Aires, Georgetown"
//              }
