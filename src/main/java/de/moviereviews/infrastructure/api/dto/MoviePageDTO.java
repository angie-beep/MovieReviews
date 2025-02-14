package de.moviereviews.infrastructure.api.dto;

import java.util.List;

public class MoviePageDTO {
    private List<MovieDTO> content;
    private long totalElements;
    private int totalPages;
    private int currentPage;
    private int pageSize;

    public MoviePageDTO() {
    }

    public List<MovieDTO> getContent() {
        return content;
    }
    public void setContent(List<MovieDTO> content) {
        this.content = content;
    }
    public long getTotalElements() {
        return totalElements;
    }
    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }
    public int getTotalPages() {
        return totalPages;
    }
    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
    public int getCurrentPage() {
        return currentPage;
    }
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
