package org.prog.dto.AlloDto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AlloProduct {
    private String ProductName;
    private String ActualPrice;
    private String Sku;

}
