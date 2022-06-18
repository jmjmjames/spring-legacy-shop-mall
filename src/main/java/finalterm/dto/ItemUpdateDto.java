package finalterm.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class ItemUpdateDto {

    @NotBlank
    @NotEmpty(message = "필수 항목입니다.")
    private String name;

    private Integer stockQuantity;

    public ItemUpdateDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
}

