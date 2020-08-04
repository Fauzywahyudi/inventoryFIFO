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
                    <h3>LAPORAN TRANSAKSI PENJUALAN PERTAHUN <?php echo $_GET['tahun'] ?> PERBULAN <?php echo $_GET['bulan'] ?> <br><span style="font-size: 20px;">Tanggal : <?php echo date('d/m/Y') ?></span></h3>

                </center>
            </div>
            <div class="col-12">
                <center>
                    <table border="1" width="100%">
                        <tr align="center">
                            <th>NO</th>
                            <th>No. Faktur</th>
                            <th>Tanggal</th>
                            <th>Suplier</th>
                            <th>Barang</th>
                            <th>Jumlah Item</th>
                            <th>Harga</th>
                            <th>Total</th>
                        </tr>
                        <?php include 'koneksi.php';
                        include 'utility.php';
                        $bulan = monthInt($_GET['bulan']);



                        $sql = $kon->query("SELECT transaksijual.no_fak_jual, transaksijual.tgl_jual, pelanggan.nm_pel, barang.nm_barang, transaksijual.jumlah, transaksijual.harga, transaksijual.total FROM transaksijual JOIN pelanggan ON transaksijual.kd_pel=pelanggan.kd_pel JOIN barang ON transaksijual.kd_barang=barang.kd_barang WHERE YEAR(transaksijual.tgl_jual)='" . $_GET['tahun'] . "' AND MONTH(transaksijual.tgl_jual)='" . $bulan . "'");

                        $no = 1;
                        while ($data = $sql->fetch_array()) {
                            $dateBeli = dateConvert($data['tgl_jual'])
                        ?>
                            <tr>
                                <td align="center"><?php echo $no ?></td>
                                <td><?php echo $data['no_fak_jual'] ?></td>
                                <td><?php echo $dateBeli ?></td>
                                <td><?php echo $data['nm_pel'] ?></td>
                                <td><?php echo $data['nm_barang'] ?></td>
                                <td><?php echo $data['jumlah'] ?></td>
                                <td><?php echo $data['harga'] ?></td>
                                <td><?php echo $data['total'] ?></td>
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