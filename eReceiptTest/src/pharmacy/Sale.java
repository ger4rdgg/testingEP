package pharmacy;

import data.PatientContr;
import data.ProductID;

import java.math.BigDecimal;
import java.util.*;

public class Sale {

    private int saleCode;
    private Date date;
    private BigDecimal amount;
    private boolean isClosed;
    private List<ProductSaleLine> lines = new ArrayList<>();

    public List<ProductSaleLine> getLines() {
        return lines;
    }

    public Sale(int code) {
        saleCode = code;
        date = new Date();
        isClosed = false;
        amount = new BigDecimal(0);

    }


    public void addLine(ProductID prodID, BigDecimal price, PatientContr contr) throws SaleClosedException{

        if(isClosed())
            throw new SaleClosedException("Sale is closed");

        BigDecimal partialprice = price.multiply(contr.getAportation());
        partialprice = partialprice.divide(new BigDecimal(100));
        lines.add(new ProductSaleLine(prodID, partialprice ));

    }
    private void calculateAmount(){

        for(ProductSaleLine line : lines){

            amount = amount.add(line.parcialPrice);
        }

    }
    private void addTaxes() throws  SaleClosedException{
        if(isClosed())
            throw new SaleClosedException("Sale is closed");

        this.amount=amount.multiply(new BigDecimal(1.21));

    }

    public void CalculateFinalAmount() throws SaleClosedException {

        calculateAmount();
        addTaxes();

    }

    public BigDecimal getAmount(){
        return this.amount;
    }

    public void setClosed(){

        this.isClosed = true;
    }

    public boolean isClosed(){
        return this.isClosed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sale)) return false;
        Sale sale = (Sale) o;
        return saleCode == sale.saleCode &&
                isClosed() == sale.isClosed() &&
                Objects.equals(date, sale.date) &&
                Objects.equals(getAmount(), sale.getAmount()) &&
                Objects.equals(getLines(), sale.getLines());
    }

    @Override
    public int hashCode() {
        return Objects.hash(saleCode, date, getAmount(), isClosed(), getLines());
    }
}
