package me.study.feat.sum;

import io.opentelemetry.instrumentation.annotations.SpanAttribute;
import io.opentelemetry.instrumentation.annotations.WithSpan;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SumService {

    @WithSpan
    Integer sum(@SpanAttribute(value = "a") Integer a, @SpanAttribute(value = "b") Integer b) {
        return a + b;
    }

}
