# Manufaktura - ClojureScript UI components

**Copy-first UI components for ClojureScript and Reagent, styled with Tailwind CSS.**

Build with polished Reagent components. Keep the source. Make them yours.

> “A chair. And something more amazing, another chair!
> Not a big deal? [chuckles]
> They are identical.
> Once upon a time, every object was made individually, by hand, which means
> each one looked unique. Horrible. Luckily, we now have Western manufacturing,
> which means we can now have two identical copies. Or a dozen.”
>
> - Jan Paweł Adamczewski, *1670*

Manufaktura brings the idea behind [shadcn/ui](https://ui.shadcn.com/) to
ClojureScript: choose a component, copy its source into your application, and
make it yours. The components combine Clojure-friendly APIs with accessible
React primitives and a coherent Tailwind-based visual language.

This is not a conventional component dependency or a framework. It is a
collection of opinionated components that you can directly use in your application that just works and looks good.

## Why this exists

ClojureScript teams should not have to choose between two poor extremes:

- opaque JavaScript UI libraries whose styling, lifecycle, and release cycle
  become application-wide constraints; or
- rebuilding dialogs, menus, focus management, keyboard navigation, and a
  consistent visual system from scratch.

This project separates those concerns:

| Concern | Tool | Responsibility |
| --- | --- | --- |
| Interaction and accessibility | [Radix UI](https://www.radix-ui.com/) and other focused React primitives | Focus management, keyboard interaction, ARIA behavior, overlays, and other difficult browser details |
| Styling method | [Tailwind CSS v4](https://tailwindcss.com/) | Local, explicit utility classes and design-token integration |
| Design defaults | Manufaktura | Coherent variants, spacing, states, composition, and component examples |
| Application API | ClojureScript + Reagent | Props maps, keyword variants, Hiccup children, and contained JavaScript interop |

The result is a **glue layer**, not another UI framework. Behavior,
presentation, and application state remain separate, and the final source
lives in your repository.

Read [Philosophy and design rationale](docs/philosophy.md) for the full
argument, tradeoffs, and project boundaries.

## What you get

- **ClojureScript-native APIs** - Reagent functions, props maps, Hiccup, and
  keyword values such as `:outline`, `:destructive`, and `:sm`.
- **Accessible foundations** - complex components build on focused primitives
  such as Radix UI rather than reimplementing accessibility behavior casually.
- **Tailwind CSS v4 styling** - visual decisions are visible where they are
  used and can be changed without overriding a package's private CSS.
- **Theme tokens** - light and dark palettes use CSS custom properties and
  OKLCH values in [`resources/css/app.css`](resources/css/app.css).
- **Source ownership** - copied components can be read, changed, tested, or
  deleted on your schedule.
- **Isolated examples** - Storybook provides previews, component stories, API
  notes, and source examples.

## The ownership model

There is intentionally no Manufaktura runtime artifact to add to
`deps.edn` and no npm package containing the component implementation.
Adoption happens per component:

1. Find the component and its story in this repository or Storybook.
2. Copy the component namespace into your project's source tree.
3. Copy any shared namespaces it requires, commonly utilities under
   [`src/cljs/manufaktura/utils`](src/cljs/manufaktura/utils).
4. Install only the JavaScript dependencies required by that component.
5. Add or adapt the design tokens from
   [`resources/css/app.css`](resources/css/app.css).
6. Rename namespaces and modify the source to fit your application.

Copying is a deliberate tradeoff: upstream changes are not automatically
applied to your application. In return, your UI is not coupled to this
project's release cycle or abstraction boundaries.

## Example

A component remains ordinary Reagent/Hiccup at the call site:

```clojure
(ns example.actions
  (:require
   [manufaktura.ui.components.button :refer [button]]))

(defn delete-action []
  [button {:variant :destructive
           :size :sm
           :on-click #(js/console.log "delete")}
   "Delete"])
```

The namespace above reflects this repository's layout. After copying, use the
namespace you chose for your application.

Components conventionally accept a props map first and children after it.
JavaScript interop and prop normalization stay inside the component, while
callers work with Clojure data.

## Requirements

The exact dependencies depend on the components you copy. This repository is
currently developed with:

- ClojureScript compiled by `shadow-cljs`
- Reagent 2
- React 19 (the current `package.json` baseline)
- Tailwind CSS 4
- component-specific npm packages such as Radix UI primitives

Treat these as the tested development baseline, not as a claim that every
component requires every dependency listed in `package.json`.

## For maintainers

### Explore and develop locally

Prerequisites: a JDK, Clojure CLI, [Babashka](https://babashka.org/), and
Node.js/npm.

```bash
npm install
bb dev
```

`bb dev` generates the story module configuration, compiles the ClojureScript
stories, starts the Shadow CLJS watcher, and serves Storybook on
<http://localhost:6010>.

Useful tasks:

```bash
bb watch-stories     # watch ClojureScript stories only
bb compile-stories   # compile stories once
bb storybook         # prepare stories and run Storybook
bb build-storybook   # build the static Storybook site
bb clean             # remove generated build artifacts
```

`bb build-storybook` (or `npm run build-storybook`) prepares the ClojureScript
stories and builds the static web app into `storybook-static/`.

## Contributing

For architectural context, start with [`docs/philosophy.md`](docs/philosophy.md).

## License

[LICENSE](LICENSE) © Mateusz Mazurczak
