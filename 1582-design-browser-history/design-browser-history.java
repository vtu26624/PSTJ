class BrowserHistory {

    private List<String> pages;
    private int currentPage;
    private int latestPage;

    public BrowserHistory(String homepage) {
        this.pages = new ArrayList<>();
        this.pages.add(homepage);
        currentPage = 0;
        latestPage = 0;
    }
    
    public void visit(String url) {
        if (currentPage + 1 == pages.size())
            pages.add(url);
        else
            pages.set(currentPage + 1, url);
        // replace the pages with new page
        currentPage++;
        latestPage = currentPage;
    }
    
    public String back(int steps) {
        currentPage = Math.max(currentPage - steps, 0);
        return pages.get(currentPage);
    }
    
    public String forward(int steps) {
        currentPage = Math.min(currentPage + steps, latestPage);
        return pages.get(currentPage);
    }
}