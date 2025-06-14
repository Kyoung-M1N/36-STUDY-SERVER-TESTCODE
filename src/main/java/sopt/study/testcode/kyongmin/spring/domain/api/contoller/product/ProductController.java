package sopt.study.testcode.kyongmin.spring.domain.api.contoller.product;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import sopt.study.testcode.kyongmin.spring.domain.api.ApiResponse;
import sopt.study.testcode.kyongmin.spring.domain.api.contoller.product.dto.request.ProductCreateRequest;
import sopt.study.testcode.kyongmin.spring.domain.api.service.product.ProductService;
import sopt.study.testcode.kyongmin.spring.domain.api.service.product.response.ProductResponse;

@RestController
@RequiredArgsConstructor
public class ProductController {
	private final ProductService productService;

	@PostMapping("/api/v1/products/new")
	public ApiResponse<ProductResponse> createProduct(@Valid @RequestBody ProductCreateRequest request) {
		return ApiResponse.ok(productService.createProduct(request.toServiceRequest()));
	}

	@GetMapping("/api/v1/products/selling")
	public ApiResponse<List<ProductResponse>> getSellingProducts() {
		return ApiResponse.ok(productService.getSellingProducts());
	}
}
