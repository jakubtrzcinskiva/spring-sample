#!make
include .env
MAKE_VERBOSE=1
deps-up:
	@docker-compose -f docker-compose.deps.yml up -d
deps-stop:
	@docker-compose -f docker-compose.deps.yml stop
deps-recreate:
	@docker-compose -f docker-compose.deps.yml up --build -d