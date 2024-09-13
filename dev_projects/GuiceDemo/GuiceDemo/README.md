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

- Guice `AbstractModule`
  - A support class for Modules which reduces repetition and results in a more readable configuration. Simply extend this class, implement configure(), and call the inherited methods which mirror those found in Binder.
  - https://google.github.io/guice/api-docs/3.0/javadoc/com/google/inject/AbstractModule.html

- Guice `configure` VS `install`
  - `configure` Method:
     - Purpose: This method is primarily used to define bindings within the module itself. It's where you typically specify which classes or interfaces should be injected with which implementations.
     - Binding Scope: Bindings defined in configure are scoped to the current module. This means they are only available within the module and its child modules.
  - `install` Method:
     - Purpose: This method is used to install other modules into the current module. This allows you to reuse configuration code and create modular architectures.
     - Binding Scope: Bindings defined in the installed modules are available within the current module and its child modules.
  - key difference:
    - Scope: Bindings in configure are scoped to the current module, while bindings in installed modules are available globally within the current module and its children.
    - Overriding: Bindings in configure can be overridden by bindings in installed modules, while bindings in installed modules always take precedence.
    - Reuse: install is used to reuse configuration code by incorporating other modules into the current module.

## Ref
  - https://github.com/google/guice/wiki/Injections
  - https://www.baeldung.com/guice
  