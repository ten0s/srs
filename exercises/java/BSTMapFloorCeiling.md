---
layout: exercise
title: Binary Search Tree Floor/Ceiling
question_text: >-
  Find <i>floor</i> (the largest key that is less than or equal to the given key) and
  <i>ceiling</i> (the smallest key that is greater than or equal to the given key) in
  the binary search tree
  <pre>
        +----5----+
        |         |
        1--+   +--7--+
           |   |     |
           3   6     9
  </pre>
solution_file: /sources/java/BSTMapFloorCeiling.java
library_files:
- /sources/java/BSTMap.java
- /sources/java/Assert.java
- /sources/java/ArrayUtil.java
language: java
command: javac BSTMapFloorCeiling.java && java BSTMapFloorCeiling
---
