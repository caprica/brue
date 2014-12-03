Brue
====

The Brue project provides a Java framework to manage and control devices
connected to a [Philips Hue](http://www.meethue.com "Philips Hue") bridge.

This project is essentially a specification for how components interact
with the bridge, a particular implementation of that specification is
required to actually use the web-services provided by the bridge.

The currently available implementations are:

 - Brue-OkHttp

Brue can be used in standalone rich-client applications, web applications,
and Android applications.

Usage
-----

Usage is designed to be very simple.

Immutability is also favoured where practical. A fluent API is used when
creating or modifying bridge resources.

To register a new user:

```
AuthoriseResult authorised = bridgeService.authorisation().authorise(new Authorisation("test user", "IAmPenguin"));
```

To list the available lights in the system:

```
Map<Integer,Light> lights = bridgeService.light().lights();
```

To get a particular light:

```
Light light = bridgeServce.light().light(1);
```

To create a group for multiple lights:

```
CreateResult createdGroup = groupService.group().create(
    group()
        .name("BimbleGroup")
        .lights("1", "2", "3")
    );
```

In this last example the second `group()` invocation actually uses a static
import for a builder object.

The `createdGroup` result will contain, if successful, the ID for the newly
created group. This can then be used to change the state of the group, e.g. to
turn all of the lights in the group (assuming the group ID is 3) on:

```
bridgeService.group().state(3,
    state()
        .brightness(200)
        .on(true)
    );
```

Again in this latter example, the second `state()` invocation is a static
import for a builder object.

These examples just scratch the surface of what is possible...

Status
------

This project is currently in an experimental stage but is usable and robust.

Most, but not all, Bridge features are implemented - the remainder will be
completed shortly.

There may well be a small number of FIXMEs and TODOs littering the source code
for the time being... this project is in fact a port of initial Scala version
so there may be some Scala remnants remaining.

Remote vs Local API
-------------------

At the present time, this project deals only with the local bridge API - i.e.
it works with bridge devices on the same network as the client application.

This is because there is not yet an *official* remote API (i.e. for control
over the internet) provided by Philips although this has been promised as
coming soon.

This severely limits the usefulness of the product so hopefully that API will
indeed come soon.

There are various projects available that *do* support a remote API but
these are completely unofficial.

Maven Dependency
----------------

Add the following Maven dependency to your own project pom.xml:

```
<dependency>
    <groupId>uk.co.caprica</groupId>
    <artifactId>brue</artifactId>
    <version>1.0.0</version>
</dependency>
```

License
-------

The Brue framework is provided under the LGPL, version 3 or later.
