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
                    <h3>LAPORAN DATA BARANG <br><span style="font-size: 20px;">Tanggal : <?php echo date('d/m/Y') ?></span></h3>

                </center>
            </div>
            <div class="col-12">
                <center>
                    <table border="1" width="100%">
                        <tr align="center">
                            <th>NO</th>
                            <th>Kode Barang</th>
                            <th>Nama Barang</th>
                            <th>Satuan</th>
                            <th>Harga</th>
                            <th>Stock</th>
                            <th>Expired</th>
                            <th>Tanggal Beli</th>
                        </tr>
                        <?php include 'koneksi.php';

                        function dateConvert($data)
                        {
                            $result = "";
                            $year = substr($data, 0, 4);
                            $mount = substr($data, 5, 2);
                            $day = substr($data, 8, 2);
                            $result = $day . "-" . $mount . "-" . $year;
                            return $result;
                        }

                        $sql = $kon->query("SELECT * FROM barang ORDER BY tgl_beli ASC");

                        $no = 1;
                        while ($data = $sql->fetch_array()) {
                            $dateExpired = dateConvert($data['expired']);
                            $dateBeli = dateConvert($data['tgl_beli']);
                        ?>
                            <tr>
                                <td align="center"><?php echo $no ?></td>
                                <td><?php echo $data['kd_barang'] ?></td>
                                <td><?php echo $data['nm_barang'] ?></td>
                                <td><?php echo $data['satuan'] ?></td>
                                <td align="right"><?php echo "Rp " . $data['harga_jual'] ?></td>
                                <td align="right"><?php echo $data['stock'] . " " . $data['satuan'] ?></td>
                                <td align="right"><?php echo $dateExpired ?></td>
                                <td align="right"><?php echo $dateBeli ?></td>
                            </tr>
                        <?php
                            $no++;
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