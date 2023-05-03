package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class ApplicationTest {
    @Test
    void invalidParameters() {
        String[] args = new String[]{};
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Application.main(args))
                .withMessage("path and word mast be in args...");
    }


}