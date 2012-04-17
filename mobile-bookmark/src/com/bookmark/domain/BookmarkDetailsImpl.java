package com.bookmark.domain;

public class BookmarkDetailsImpl implements BookmarkDetails {

	private String title;
	private String pageNumber;
	private String dateAdded;
	
	/* (non-Javadoc)
	 * @see com.bookmark.domain.BookmarkDetails#getTitle()
	 */
	@Override
	public String getTitle() {
		return title;
	}
	
	/* (non-Javadoc)
	 * @see com.bookmark.domain.BookmarkDetails#setTitle(java.lang.String)
	 */
	@Override
	public void setTitle(String title) {
		this.title = title;
	}
	/* (non-Javadoc)
	 * @see com.bookmark.domain.BookmarkDetails#getPageNumber()
	 */
	@Override
	public String getPageNumber() {
		return pageNumber;
	}
	/* (non-Javadoc)
	 * @see com.bookmark.domain.BookmarkDetails#setPageNumber(java.lang.String)
	 */
	@Override
	public void setPageNumber(String pageNumber) {
		this.pageNumber = pageNumber;
	}
	/* (non-Javadoc)
	 * @see com.bookmark.domain.BookmarkDetails#getDateAdded()
	 */
	@Override
	public String getDateAdded() {
		return dateAdded;
	}
	/* (non-Javadoc)
	 * @see com.bookmark.domain.BookmarkDetails#setDateAdded(java.lang.String)
	 */
	@Override
	public void setDateAdded(String dateAdded) {
		this.dateAdded = dateAdded;
	}


}
