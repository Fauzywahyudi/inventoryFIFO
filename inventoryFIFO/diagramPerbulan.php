<style>
    #container {
        height: 400px;
    }

    .highcharts-figure,
    .highcharts-data-table table {
        min-width: 310px;
        max-width: 800px;
        margin: 1em auto;
    }

    #datatable {
        font-family: Verdana, sans-serif;
        border-collapse: collapse;
        border: 1px solid #EBEBEB;
        margin: 10px auto;
        text-align: center;
        width: 100%;
        max-width: 500px;
    }

    #datatable caption {
        padding: 1em 0;
        font-size: 1.2em;
        color: #555;
    }

    #datatable th {
        font-weight: 600;
        padding: 0.5em;
    }

    #datatable td,
    #datatable th,
    #datatable caption {
        padding: 0.5em;
    }

    #datatable thead tr,
    #datatable tr:nth-child(even) {
        background: #f8f8f8;
    }

    #datatable tr:hover {
        background: #f1f7ff;
    }
</style>

<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/data.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/accessibility.js"></script>

<figure class="highcharts-figure">
    <div id="container"></div>
    <p class="highcharts-description">

    </p>

    <table id="datatable">
        <thead>
            <tr>
                <th>Tahun</th>
                <th>Transaksi</th>
            </tr>
        </thead>
        <tbody>
            <?php include 'koneksi.php';

            if ($_GET['tipe'] == "pembelian") {
                $tabel = "transaksibeli";
                $tglColumn = "tgl_beli";
                $title = "Pembelian";
            } else {
                $tabel = "transaksijual";
                $tglColumn = "tgl_jual";
                $title = "Penjualan";
            }

            $sql = $kon->query("SELECT CONCAT(YEAR($tglColumn),'/',MONTH($tglColumn)) AS TAHUN_BULAN, COUNT(*) as JUMLAH_TRANSAKSI FROM $tabel WHERE YEAR($tglColumn)='2020' GROUP BY YEAR($tglColumn),MONTH($tglColumn)");
            while ($data = $sql->fetch_array()) {
            ?>
                <tr>
                    <td><?php echo $data['TAHUN_BULAN'] ?></td>
                    <td><?php echo $data['JUMLAH_TRANSAKSI'] ?></td>
                </tr>
            <?php
            }
            ?>
        </tbody>
    </table>
</figure>

<script>
    Highcharts.chart('container', {
        data: {
            table: 'datatable'
        },
        chart: {
            type: 'column'
        },
        title: {
            text: 'Diagram Transaksi <?php echo $title ?> Perbulan Pada Tahun <?php echo $_GET['tahun'] ?>'
        },
        yAxis: {
            allowDecimals: false,
            title: {
                text: 'Jumlah Transaksi'
            }
        },
        tooltip: {
            formatter: function() {
                return '' +
                    this.point.y + ' Transaksi';
            }
        }
    });
</script>