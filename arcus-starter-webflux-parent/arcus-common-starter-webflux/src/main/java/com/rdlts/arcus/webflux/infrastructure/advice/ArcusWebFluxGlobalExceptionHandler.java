package com.rdlts.arcus.webflux.infrastructure.advice;

import com.rdlts.arcus.common.sharedkernel.exception.ArcusCommonRuntimeException;
import com.rdlts.arcus.common.sharedkernel.response.ArcusRestResponseBody;
import com.rdlts.arcus.webflux.infrastructure.adapter.WebExchangeBindExceptionAdapter;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;
import reactor.core.publisher.Mono;

/**
 * GlobalExceptionHandler
 *
 * @author wangjialong
 * @since 2025/7/24 14:07
 */
@RestControllerAdvice(basePackages = "com.rdlts.arcus")
@Log4j2
public class ArcusWebFluxGlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public Mono<ArcusRestResponseBody<?>> handleRuntimeException(RuntimeException ex) {
        log.error("RuntimeException occurred: {} | {}", ex.getMessage(), ex.getClass().getName());
        return Mono.just(
                ArcusRestResponseBody.error(500, ex.getMessage())
        );
    }

    @ExceptionHandler(ArcusCommonRuntimeException.class)
    public Mono<ArcusRestResponseBody<?>> handleArcusCommonRuntimeException(ArcusCommonRuntimeException ex) {
        log.error("ArcusCommonRuntimeException occurred: {} | {}", ex.getMessage(), ex.getClass().getName());
        return Mono.just(ex.toResponseBody());
    }

    @ExceptionHandler(WebExchangeBindException.class)
    public Mono<ArcusRestResponseBody<?>> handleValidationError(WebExchangeBindException webExchangeBindException) {
        log.error("WebExchangeBindException occurred: {} | {}", webExchangeBindException.getMessage(), webExchangeBindException.getClass().getName());
        return Mono.just(WebExchangeBindExceptionAdapter.toResponseBody(webExchangeBindException));
    }

}
