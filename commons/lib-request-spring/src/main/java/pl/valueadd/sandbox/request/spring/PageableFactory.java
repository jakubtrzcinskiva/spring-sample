package pl.valueadd.sandbox.request.spring;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import pl.valueadd.sandbox.request.dto.BaseRequest;

public class PageableFactory {
    
    public static Pageable create(BaseRequest request){
        final var sort = request.getSort();
        final var pageNumber = request.getPageNumber();
        final var pageSize = request.getPageSize();

        if(sort != null && !sort.isEmpty()) {
            String[] parts = sort.split(" ");
            if(parts.length >= 2) {
                return PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.fromString(parts[1].toUpperCase()), parts[0]));
            } else {
                return PageRequest.of(pageNumber, pageSize, Sort.by(parts[0]));
            }
        } else {
            return PageRequest.of(pageNumber, pageSize);
        }
    }
}