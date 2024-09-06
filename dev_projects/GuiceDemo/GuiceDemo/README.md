# Guice Demo

## Install
- JDK 11

## Steps
1. Create interface, its impl (implementation)
2. Module binding interface to impl
3. Create injector via module
4. get class instance via injector
5. uses methods defined in impl

## Concept

- Guice Main purpose:
  - configuration : add dependency to `guice map`, so app can use
  - injection : decouple code dep, make testing easier

- Inject can be applied on
  - value
  - constructor
  - method

- `@Inject`
  - like `@authwired` in spring boot, auto import bean to container, so can be accessed/used by other coee

- `@Provide`
  - like `@component`, `@service` ... in spring boot, expose this class to container, so can be used by other code


## Ref
  - https://github.com/google/guice/wiki/Injections
  - https://www.baeldung.com/guice
  