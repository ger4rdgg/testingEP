package pharmacy;

import data.PatientContr;
import data.ProductID;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Sale {

    private int saleCode;
    private Date date;
    private BigDecimal amount;
    private boolean isClosed;
    private List<ProductSaleLine> lines = new ArrayList<ProductSaleLine>();

    public Sale(int code) {
        saleCode = code;
        date = new Date();
        isClosed = false;
        amount = new BigDecimal(0);

    }

    public  class ProductSaleLine{
        ProductID prodid;
        BigDecimal parcialPrice;

        public ProductSaleLine(ProductID prodid, BigDecimal parcialPrice) {
            this.prodid = prodid;
            this.parcialPrice = parcialPrice;
        }
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


}
