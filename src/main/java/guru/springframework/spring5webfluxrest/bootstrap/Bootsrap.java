package guru.springframework.spring5webfluxrest.bootstrap;

import guru.springframework.spring5webfluxrest.domain.Category;
import guru.springframework.spring5webfluxrest.domain.Vendor;
import guru.springframework.spring5webfluxrest.repository.CategoryRepository;
import guru.springframework.spring5webfluxrest.repository.VendorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootsrap implements CommandLineRunner {

    private CategoryRepository categoryRepository;

    private VendorRepository vendorRepository;

    public Bootsrap(CategoryRepository categoryRepository, VendorRepository vendorRepository) {
        this.categoryRepository = categoryRepository;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        // block tells reactor to subscribe and then invoke
        if (categoryRepository.count().block() == 0) {
            // load data
            System.out.println("#### LOADING CATEGORY DATA");
            categoryRepository.save(Category.builder()
                    .description("Fruits").build()).block();
            categoryRepository.save(Category.builder()
                    .description("Nuts").build()).block();
            categoryRepository.save(Category.builder()
                    .description("Breads").build()).block();
            categoryRepository.save(Category.builder()
                    .description("Meats").build()).block();
            categoryRepository.save(Category.builder()
                    .description("Eggs").build()).block();
            System.out.println("Loaded categories: " + categoryRepository.count().block());

            // load data
            System.out.println("#### LOADING VENDOR DATA");
            vendorRepository.save(Vendor.builder()
                    .firstName("Joe")
                    .lastName("Buck").build()).block();
            vendorRepository.save(Vendor.builder()
                    .firstName("Michael")
                    .lastName("Weston").build()).block();
            vendorRepository.save(Vendor.builder()
                    .firstName("Jessie")
                    .lastName("Waters").build()).block();
            vendorRepository.save(Vendor.builder()
                    .firstName("Bill")
                    .lastName("Nershi").build()).block();
            vendorRepository.save(Vendor.builder()
                    .firstName("Jimmy")
                    .lastName("Buffet").build()).block();
            System.out.println("Loaded vendors: " + vendorRepository.count().block());
        }
    }
}
