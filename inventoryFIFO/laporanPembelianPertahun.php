<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Laporan Barang</title>
    <!-- Tempusdominus Bbootstrap 4 -->
    <link rel="stylesheet" href="plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css">
    <link rel="stylesheet" href="bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

    <!-- jQuery -->
    <script src="plugins/jquery/jquery.min.js"></script>
    <!-- jQuery UI 1.11.4 -->
    <script src="plugins/jquery-ui/jquery-ui.min.js"></script>
    <!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
</head>

<body>
    <div class="container">
        <div class="row">
            <div class="col-2"></div>
            <div class="col-8">
                <center>
                    <h2>SISTEM INFORMASI INVENTORY <br>TOKO DAYA FAMILY</h2>
                </center>
            </div>
            <div class="col-2">

            </div>
            <div class="col-12">
                <hr>
            </div>
            <div class="col-12">
                <center>
                    <h3>LAPORAN TRANSAKSI PEMBELIAN PERTAHUN <?php echo $_GET['tahun'] ?> <br><span style="font-size: 20px;">Tanggal : <?php echo date('d/m/Y') ?></span></h3>

                </center>
            </div>
            <div class="col-12">
                <center>
                    <table border="1" width="100%">
                        <tr align="center">
                            <th>NO</th>
                            <th>Bulan Tahun</th>
                            <th>Total</th>
                        </tr>
                        <?php include 'koneksi.php';
                        include 'utility.php';



                        $sql = $kon->query("SELECT CONCAT(YEAR(tgl_beli),'/',MONTH(tgl_beli)) AS TAHUN_BULAN, SUM(total) as TOTAL_TRANSAKSI FROM transaksibeli WHERE YEAR(tgl_beli)='$_GET[tahun]' GROUP BY YEAR(tgl_beli),MONTH(tgl_beli)");

                        $no = 1;
                        while ($data = $sql->fetch_array()) {
                            $mount =  substr($data['TAHUN_BULAN'], 5);
                            $year = substr($data['TAHUN_BULAN'], 0, 4);

                        ?>
                            <tr>
                                <td align="center"><?php echo $no ?></td>
                                <td align="center"><?php echo mountName($mount) . " $year" ?></td>
                                <td align="right"><?php echo "Rp. " . number_format($data['TOTAL_TRANSAKSI']) ?></td>
                            </tr>
                        <?php
                            $no++;
                        }

                        if ($sql->num_rows == 0) {
                        ?>
                            <tr>
                                <th colspan="8">
                                    <center>Tidak Ada Data</center>
                                </th>
                            </tr>

                            <?php
                        } else {
                            $sqlJumlah = $kon->query("SELECT SUM(total) as TOTAL_TRANSAKSI FROM transaksibeli WHERE YEAR(tgl_beli)='$_GET[tahun]'");
                            while ($dataArr = $sqlJumlah->fetch_array()) {
                            ?>
                                <tr>
                                    <td colspan="2" align="center"><b>Total Pembelian</b></td>
                                    <td align="right"><b><?php echo "Rp. " . number_format($dataArr['TOTAL_TRANSAKSI']) ?></b></td>
                                </tr>

                        <?php
                            }
                        }

                        ?>
                    </table>
                </center>
            </div>
            <div class="col-8"></div>
            <div class="col-4">
                <br>
                <span>Padang, <?php echo date('d/m/Y') ?></span> <br>
                <span>Mengetahui</span>
                <p></p>
                <p><br></p>
                <p><br></p>
                ( xxxxxxxxx )
            </div>

        </div>
    </div>


    <script>
        print()
    </script>
</body>

<script src="plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="plugins/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js"></script>

<script>
    $.widget.bridge('uibutton', $.ui.button)
</script>

</html>