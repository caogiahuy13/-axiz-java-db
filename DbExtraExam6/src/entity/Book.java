package entity;

public class Book {
	Integer bookId;
	String bookName;
	Integer publisher;
	Integer price;

	public Book() {

	}

	public Book(String bookName, Integer publisher, Integer price) {
		this.bookName = bookName;
		this.publisher = publisher;
		this.price = price;
	}

	public Book(Integer bookId, String bookName, Integer publisher, Integer price) {
		this.bookId = bookId;
		this.bookName = bookName;
		this.publisher = publisher;
		this.price = price;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Integer getPublisher() {
		return publisher;
	}

	public void setPublisher(Integer publisher) {
		this.publisher = publisher;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

}
