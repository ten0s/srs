---
layout: exercise
title: Lists Merge Point
question_text: >-
  Given two lists of different lengths that might merge at a point,
  determine the merge point using the "Runner" technique
  <pre>
    9-->8-->7
            |
            V
    1-->2-->3-->4-->5
  </pre>
solution_file: /sources/java/ListsMergePoint.java
library_files:
- /sources/java/Node.java
- /sources/java/Pair.java
- /sources/java/Assert.java
- /sources/java/ArrayUtil.java
language: java
command: javac ListsMergePoint.java && java ListsMergePoint
---
