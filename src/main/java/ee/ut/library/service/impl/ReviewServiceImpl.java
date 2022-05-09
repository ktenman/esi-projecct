package ee.ut.library.service.impl;

import ee.ut.library.domain.entity.Review;
import ee.ut.library.exception.ReviewNotFoundException;
import ee.ut.library.repository.ReviewRepository;
import ee.ut.library.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ReviewServiceImpl implements ReviewService {
    public final ReviewRepository reviewRepository;

    @Override
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    @Override
    public Review getOne(Long id) {
        return reviewRepository.findById(id).orElseThrow(() -> new ReviewNotFoundException(id));
    }

    @Override
    public Review insert(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public Review update(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public void deleteById(Long id) {
        reviewRepository.deleteById(id);
    }
}
