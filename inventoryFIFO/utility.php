<?php
function dateConvert($data)
{
    $result = "";
    $year = substr($data, 0, 4);
    $mount = substr($data, 5, 2);
    $day = substr($data, 8, 2);
    $result = $day . "-" . $mount . "-" . $year;
    return $result;
}

function monthInt($data)
{
    switch ($data) {
        case 'Januari':
            return '01';
            break;
        case 'Februari':
            return '02';
            break;
        case 'Maret':
            return '03';
            break;
        case 'April':
            return '04';
            break;
        case 'Mei':
            return '05';
            break;
        case 'Juni':
            return '06';
            break;
        case 'Juli':
            return '07';
            break;
        case 'Agustus':
            return '08';
            break;
        case 'September':
            return '09';
            break;
        case 'Oktober':
            return '10';
            break;
        case 'November':
            return '11';
            break;
        case 'Desember':
            return '12';
            break;
    }
}

function mountName($data)
{
    switch ($data) {
        case '1':
            return 'Januari';
            break;
        case '2':
            return 'Februari';
            break;
        case '3':
            return 'Maret';
            break;
        case '4':
            return 'April';
            break;
        case '5':
            return 'Mei';
            break;
        case '6':
            return 'Juni';
            break;
        case '7':
            return 'Juli';
            break;
        case '8':
            return 'Agustus';
            break;
        case '9':
            return 'September';
            break;
        case '10':
            return 'Oktober';
            break;
        case '11':
            return 'November';
            break;
        case '12':
            return 'Desember';
            break;
    }
}
