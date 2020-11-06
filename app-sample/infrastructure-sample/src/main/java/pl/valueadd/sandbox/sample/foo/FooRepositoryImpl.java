package pl.valueadd.sandbox.sample.foo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import javax.transaction.Transactional;

import pl.valueadd.sandbox.request.spring.PageableFactory;
import pl.valueadd.sandbox.sample.foo.dto.*;
import pl.valueadd.sandbox.sample.foo.exception.FooNotFoundException;

import java.util.Optional;
import java.util.UUID;
import org.springframework.cache.annotation.Cacheable;

import javax.validation.Valid;
import org.springframework.cache.annotation.Caching;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;

import java.util.List;

@RequiredArgsConstructor
@Component
@Transactional
class FooRepositoryImpl implements FooRepository {

    private final FooEntityMapper mapper;

    private final FooEntityRepository repository;

    @Cacheable(value = "foo-getOne")
    @Override
    public Optional<FooState> findById(UUID id) {
        return repository.findById(id).map(mapper::toDto);
    }

    @Cacheable(value = "foo-getOne")
    @Override
    public FooState getOne(UUID id) {
        return mapper.toDto(getOneEntity(id));
    }

    @Caching(evict = {
    @CacheEvict(value = "foo-list", allEntries = true), 
    @CacheEvict(value = "foo-count", allEntries = true) 
    }, put = {
    @CachePut(value = "foo-getOne", key = "#result.id")
    })
    @Override
    public FooState create(@Valid() FooState model) {
        return mapper.toDto(repository.save(mapper.toEntity(model)));
    }

    @Caching(evict = {
    @CacheEvict(value = "foo-list", allEntries = true), 
    @CacheEvict(value = "foo-count", allEntries = true), 
    @CacheEvict(value = "foo-getOne", key = "#id") 
    }, put = {
    @CachePut(value = "foo-getOne", key = "#result.id")
    })
    @Override
    public FooState update(UUID id, @Valid() FooState model) {
        return mapper.toDto(mapper.applyChanges(getOneEntity(id), model));
    }

    @Caching(evict = {
    @CacheEvict(value = "foo-list", allEntries = true), 
    @CacheEvict(value = "foo-count", allEntries = true), 
    @CacheEvict(value = "foo-getOne", key = "#id")
    })
    @Override
    public void delete(UUID id) {
        repository.delete(getOneEntity(id));
    }

    @Cacheable(value = "foo-list")
    @Override
    public List<FooState> findAll(FooRequest query) {
        return repository.findAll(new FooEntitySpec(query), PageableFactory.create(query)).map(mapper::toDto).getContent();
    }

    @Cacheable(value = "foo-count")
    @Override
    public long count(FooRequest query) {
        return repository.count(new FooEntitySpec(query));
    }

    private FooEntity getOneEntity(UUID id) {
        return repository.findById(id).orElseThrow(FooNotFoundException.ofId(id));
    }
}
