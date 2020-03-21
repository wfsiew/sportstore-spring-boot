package sportsstore.api.app.model;

public class PagingInfo {

    private long totalItems;
    private int itemsPerPage;
    private int currentPage;

    /**
     * @return int return the totalItems
     */
    public long getTotalItems() {
        return totalItems;
    }

    /**
     * @param totalItems the totalItems to set
     */
    public void setTotalItems(long totalItems) {
        this.totalItems = totalItems;
    }

    /**
     * @return int return the itemsPerPage
     */
    public int getItemsPerPage() {
        return itemsPerPage;
    }

    /**
     * @param itemsPerPage the itemsPerPage to set
     */
    public void setItemsPerPage(int itemsPerPage) {
        this.itemsPerPage = itemsPerPage;
    }

    /**
     * @return int return the currentPage
     */
    public int getCurrentPage() {
        return currentPage;
    }

    /**
     * @param currentPage the currentPage to set
     */
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    /**
     * @return int return the totalPAges
     */
    public int getTotalPAges() {
        return (int) Math.ceil((double) getTotalItems() / getItemsPerPage());
    }
}