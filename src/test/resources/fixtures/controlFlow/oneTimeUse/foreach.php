<?php

<warning descr="Variable $array is redundant.">$array</warning> = [];
foreach ($array as $value) {}

/* @var $source string[] */
<warning descr="Variable $array is redundant.">$array</warning> = [];
foreach ($array as $value) {}

/* @var $array string[] */
$array = [];
foreach ($array as $value) {}