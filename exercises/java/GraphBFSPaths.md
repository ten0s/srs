---
layout: exercise
title: Graph BFS Paths
question_text: >-
  Is there a path from <i>s</i> to a given target vertex <i>v</i>?
  If so, find such a <i>shortest</i> path and its distance
  <table border="1">
    <tr>
      <td><img relative_src="/assets/images/tinyG.png" title="tinyG"></td>
    <tr>
  </table>
solution_file: /sources/java/GraphBFSPaths.java
library_files:
- /sources/java/Assert.java
- /sources/java/ArrayUtil.java
- /sources/java/Graph.java
- /sources/java/GraphUtil.java
- /sources/java/DirectedEdge.java
language: java
command: javac GraphBFSPaths.java && java GraphBFSPaths
---
