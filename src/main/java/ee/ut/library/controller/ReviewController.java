package ee.ut.library.controller;

import ee.ut.library.domain.entity.Review;
import ee.ut.library.service.ReviewService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping
    @ApiOperation(value = "Creates a new review for a book")
    public Review insert(@Valid @RequestBody Review review) {
        return reviewService.insert(review);
    }

    @PutMapping
    @ApiOperation(value = "Updates review")
    public Review update(@Valid @RequestBody Review review) {
        return reviewService.update(review);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete the review by its id")
    public void deleteById(@PathVariable Long id) {
        reviewService.deleteById(id);
    }
}
