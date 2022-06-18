package finalterm.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class ItemDto {

    @NotBlank
    @NotEmpty(message = "필수 항목입니다.")
    private String name;

    private Integer price;

    private Integer stockQuantity;

    @NotBlank
    @NotEmpty(message = "필수 항목입니다.")
    private String dType;

    @NotBlank
    @NotEmpty(message = "필수 항목입니다.")
    private String company;

    @NotBlank
    @NotEmpty(message = "필수 항목입니다.")
    private String detail;

    public ItemDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public String getdType() {
        return dType;
    }

    public void setdType(String dType) {
        this.dType = dType;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
