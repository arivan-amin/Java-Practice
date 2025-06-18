package io.github.arivanamin.java.practice;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith (MockitoExtension.class)
public interface BaseUnitTest {

    Faker FAKER = new Faker();
}
