# garden-scala-hot-reload

This example shows how you can hot reload a Scala application with Garden and `sbt-revolver`.

The `hot-reload-test` module contains the Scala application, which is created from the `http4s` quick start guide (by running `sbt new http4s/http4s.g8 -b 0.21`).

The Garden module is configured to run `sbt ~reStart` instead of the normal `sbt run` command when in _dev mode_, in order to enable hot reloading, and to sync the `src` directory. You could also sync the `.sbt` configuration files, but we omitted that from the example.

To run the project with a local Kubernetes cluster, simply run `garden dev` from the repo root.

To run with a remote Kubernetes cluster, you need to replace the `context` and `defaultHostname` variables in the `project.garden.yml` configuration file with a Kubernetes context pointing to a remote cluster of yours, and a hostname that points to an ingress controller on that cluster. Then run `garden dev --env=remote`. See the [Garden docs](https://docs.garden.io/guides/remote-kubernetes) for details.

Once it's up, visit the ingress URL shown by the Garden CLI, and add e.g. `/hello/sir` to the path. You should see something like `{"message":"Hello, sir"}` in your browser.

Next, try editing `HelloWorld.scala` in the project sources. For example, change `Greeting("Hello, " + n.name).pure[F]` to something like `Greeting("Hello, my dearest " + n.name).pure[F]`. Wait a few seconds, then refresh your browser to see the updated message!

Note that this example is a little crude, and you might want the Dockerfile to be different etc. Also note that it is possible to do more elaborate module reloading with Scala with libraries like `hottie` to make it more efficient, but the idea here should get across :)
