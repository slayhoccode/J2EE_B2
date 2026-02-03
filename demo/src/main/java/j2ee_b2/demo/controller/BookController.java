package j2ee_b2.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import j2ee_b2.demo.model.Book;
import j2ee_b2.demo.service.BookService;


@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService bookService;
    // Lấy danh sách
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }
    // Láya thông tin sách theo ID
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id) {
        return bookService.getBookById(id);
    }
    // Thêm sách mới
    @PostMapping
    public String addBook(@RequestBody Book book){
        bookService.addBook(book);
        return "Book added successfully!";
    }
    // Cập nhật thông tin sách
    @PutMapping("/{id}")
    public String updateBook(@PathVariable int id, @RequestBody Book book){
        bookService.updateBook(id, book);
        return "Book updated successfully!";
    }
    // Xóa sách
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable int id){
        bookService.deleteBook(id);
        return "Book deleted successfully!";
    }
}
