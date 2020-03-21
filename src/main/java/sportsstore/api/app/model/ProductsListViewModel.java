package sportsstore.api.app.model;

public class ProductsListViewModel {

    private Iterable<Product> products;
    private PagingInfo pagingInfo;
    private String currentCategory;

    /**
     * @return Iterable<Product> return the products
     */
    public Iterable<Product> getProducts() {
        return products;
    }

    /**
     * @param products the products to set
     */
    public void setProducts(Iterable<Product> products) {
        this.products = products;
    }

    /**
     * @return PagingInfo return the pagingInfo
     */
    public PagingInfo getPagingInfo() {
        return pagingInfo;
    }

    /**
     * @param pagingInfo the pagingInfo to set
     */
    public void setPagingInfo(PagingInfo pagingInfo) {
        this.pagingInfo = pagingInfo;
    }

    /**
     * @return String return the currentCategory
     */
    public String getCurrentCategory() {
        return currentCategory;
    }

    /**
     * @param currentCategory the currentCategory to set
     */
    public void setCurrentCategory(String currentCategory) {
        this.currentCategory = currentCategory;
    }
}