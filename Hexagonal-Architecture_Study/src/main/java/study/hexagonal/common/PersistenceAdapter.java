package study.hexagonal.common;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface PersistenceAdapter {

    /**
     * 값은 논리적인 컴포넌트 이름에 대한 제안을 나타낼 수 있으며, 자동 감지된 컴포넌트인 경우 Spring 빈으로 변환됩니다.
     *
     * @return 제안된 컴포넌트 이름, (없으면 빈 문자열)
     */
    @AliasFor(annotation = Component.class)
    String value() default "";

}
